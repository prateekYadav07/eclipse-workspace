package com.in28minutes.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

	/**
	 * @implNote different type of versioning
	 * @types : 1. differnet URL 2. Request parameters 3. Custom request headers 4.
	 *        Media type versioning
	 * @return
	 */

	@GetMapping("v1/person")
	public PersonV1 getv1Person() {
		return new PersonV1("Bob Noyce");
	}

	@GetMapping("v2/person")
	public PersonV2 getv2Person() {
		return new PersonV2(new Name("Bob", "Noyce"));
	}

	@GetMapping(path = "person", params = "version=1")
	public PersonV1 getv1PersonByReqParam() {
		return new PersonV1("Bob Noyce");
	}

	@GetMapping(path = "person", params = "version=2")
	public PersonV2 getv2PersonByReqParam() {
		return new PersonV2(new Name("Bob", "Noyce"));
	}

	@GetMapping(path = "person/header", headers = "X-API-VERSION=1")
	public PersonV1 getv1PersonByReqHeader() {
		return new PersonV1("Bob Noyce");
	}

	@GetMapping(path = "person/header", headers = "X-API-VERSION=2")
	public PersonV2 getv2PersonByReqHeader() {
		return new PersonV2(new Name("Bob", "Noyce"));
	}

	@GetMapping(path = "person/header", produces = "application/vnd.company.app-v1+json")
	public PersonV1 getv1PersonByAcceptHeader() {
		return new PersonV1("Bob Noyce");
	}

	@GetMapping(path = "person/header", produces = "application/vnd.company.app-v2+json")
	public PersonV2 getv2PersonByAcceptHeader() {
		return new PersonV2(new Name("Bob", "Noyce"));
	}
}
