package com.example.AmazonDemo;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@AnalyzeClasses(packages = "com.example.AmazonDemo")
public class ArchitectureTest {

//    @Test
//    void servicesShouldNotAccessControllers() {
//        JavaClasses classes = new ClassFileImporter().importPackages("com.example.AmazonDemo");
//
//        var rule = ArchRuleDefinition.noClasses()
//                .that().resideInAPackage("..service..")
//                .should().accessClassesThat().resideInAPackage("..controller..");
//
//        rule.check(classes);
//    }

//    @Test
//    void servicesShouldBeNamedCorrectly() {
//        JavaClasses importedClasses = new ClassFileImporter().importPackages("com.example.AmazonDemo"); // root package
//
//        ArchRule rule = classes()
//                .that().resideInAPackage("..service..")
//                .should().haveSimpleNameEndingWith("Service");
//
//        rule.check(importedClasses); // run the rule
//    }

    @ArchTest
    public static final ArchRule controllersShouldBeNamedCorrectly = classes()
            .that().resideInAPackage("..controller..")
            .should().haveSimpleNameEndingWith("Controller");

}

