/*
 * Copyright 2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.data.mongodb.monitor;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import org.springframework.lang.Nullable;
import org.springframework.util.Assert;

/**
 * @author Christoph Strobl
 * @since 2.1
 */
@EqualsAndHashCode
@ToString
class SimpleMessage<S, T> implements Message<S, T> {

	private @Nullable final S raw;
	private @Nullable final T body;
	private final MessageProperties properties;

	SimpleMessage(@Nullable S raw, @Nullable T body, MessageProperties properties) {

		Assert.notNull(properties, "Properties must not be null! Use MessageProperties.empty() instead.");
		this.raw = raw;
		this.body = body;
		this.properties = properties;
	}

	@Override
	public S getRaw() {
		return raw;
	}

	@Override
	public T getBody() {
		return body;
	}

	@Override
	public MessageProperties getMessageProperties() {
		return properties;
	}
}
