package com.msyla.usergreeter.user.web;

import com.msyla.usergreeter.user.dto.UserPreferenceDto;
import com.msyla.usergreeter.user.service.UserPreferenceService;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
@RequestMapping("/api/user/preferences")
public class UserPreferenceResource {

    @Autowired
    private UserPreferenceService service;

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserPreferenceDto> create(@RequestBody UserPreferenceDto dto, UriComponentsBuilder builder) {
        UserPreferenceDto savedDto = service.create(dto);

        Link link = ControllerLinkBuilder.linkTo(UserPreferenceResource.class).slash(savedDto.getKey()).withSelfRel();
        savedDto.add(link);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/api/user/preferences/{id}").buildAndExpand(savedDto.getKey()).toUri());
        return new ResponseEntity<>(savedDto, headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserPreferenceDto> getById(@PathVariable Long id) {

        UserPreferenceDto dto = service.getById(id);

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    List<UserPreferenceDto> getAll(@RequestParam(required = false) String firstName) {
        List<UserPreferenceDto> dtos = new ArrayList<>();
        if (StringUtils.isNotBlank(firstName)) {
            UserPreferenceDto dto = service.getByFirstName(firstName);
            if (dto != null) {
                dtos.add(dto);
            }
        } else {
            dtos.addAll(service.getAll());
        }
        return dtos;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<UserPreferenceDto> update(@PathVariable Long id, @RequestBody UserPreferenceDto dto, UriComponentsBuilder builder) {

        UserPreferenceDto updatedDto = service.update(id, dto);

        Link link = ControllerLinkBuilder.linkTo(UserPreferenceResource.class
        ).slash(updatedDto.getKey()).withSelfRel();
        updatedDto.add(link);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/api/user/preferences/{id}").buildAndExpand(updatedDto.getKey()).toUri());
        return new ResponseEntity<>(updatedDto, headers, HttpStatus.CREATED);
    }
}
