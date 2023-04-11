/*
 * Copyright (c) 2023, FHE Poupex and/or its affiliates. All rights reserved.
 * FHE POUPEX PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.github.nelsoncastro.springbootrest.api;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PersonDTO {
	private final Long id;
	private final String name;
}
