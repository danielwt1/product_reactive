package com.reactive.webflux.training_webflux_reactive.config.selector;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import static com.reactive.webflux.training_webflux_reactive.TrainingWebfluxReactiveApplication.ADAPTERS_ROUTES;
import static com.reactive.webflux.training_webflux_reactive.TrainingWebfluxReactiveApplication.USECASES_ROUTE;

public class BeansImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        String[] useCaseClasses = ScannerClasses.scannerClasses(USECASES_ROUTE);
        String[] adapterClasses = ScannerClasses.scannerClasses(ADAPTERS_ROUTES);

        String[] totalScanner = new String[useCaseClasses.length + adapterClasses.length];
        System.arraycopy(useCaseClasses, 0, totalScanner, 0, useCaseClasses.length);

        System.arraycopy(adapterClasses, 0, totalScanner, useCaseClasses.length, adapterClasses.length);


        return totalScanner;
    }
}
