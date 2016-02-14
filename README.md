## Synopsis

A simple User Service that provides crud operations behind OAuth2.  Currently, the service allows for updating user preferences.  The project is built leveraging Maven, Spring Boot, Flyway, and Dozer.  There are two profiles for pointing to different dabases, H2 and PostgreSQL.

## Motivation

Initially a request from a potential client, now simply a project to showcase these various technologies working together.

## Installation

Pull and build with Maven.  Default profile is `dev_postgresql` which will point the datasource to `database:5432/usergreeter` therefore one has to coordinate these values accordingly and assure `usergreeter` schema exists.  In the case of PostgreSQL deployed locally, associate `127.0.0.1` to `database`.

For **linux** or **Ubuntu** more specifically, one would alter `/etc/hosts` by adding the following `127.0.0.1       database` under `localhost`.  The reasoning behind this is for networking with Docker containers.

Default OAuth2 credentials are user:password

## API Reference

Depending on the size of the project, if it is small and simple enough the reference docs can be added to the README. For medium size to larger projects it is important to at least provide a link to where the API reference docs live.

## Tests

No special instructions on tests, default maven behaviour runs tests.

## Contributors

Ping me of any issues, questions.

## License

The MIT License (MIT)

Copyright (c) 2016 Modest Syla

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
