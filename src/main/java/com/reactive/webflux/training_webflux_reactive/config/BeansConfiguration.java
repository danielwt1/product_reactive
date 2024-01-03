package com.reactive.webflux.training_webflux_reactive.config;

import com.reactive.webflux.training_webflux_reactive.config.selector.BeansImportSelector;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(BeansImportSelector.class)
public class BeansConfiguration {
}
