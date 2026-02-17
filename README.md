# DemoQA Playwright Automation Project

[![Java Version](https://img.shields.io/badge/Java-17%2B-orange)](https://www.oracle.com/java/)
[![Playwright](https://img.shields.io/badge/Framework-Playwright-green)](https://playwright.dev/java/)
[![JUnit 5](https://img.shields.io/badge/Test%20Runner-JUnit%205-red)](https://junit.org/junit5/)

This project is a comprehensive automated testing framework for the [DemoQA](https://demoqa.com/) portal, built with Java and Playwright. It covers various UI components including forms, alerts, frames, widgets, and complex interactions like drag-and-drop and resizing.

## 🚀 Tech Stack
* **Java 17** — Core programming language.
* **Playwright** — Modern tool for reliable cross-browser testing.
* **JUnit 5** — Testing framework for test execution and organization.
* **Log4j** — Logging utility for better debugging and traceability.
* **Page Object Model (POM)** — Architectural pattern to separate test logic from page locators.

---

## 🏗 Project Structure
The project follows a hierarchical structure to ensure scalability and maintainability:

* `src/main/java/base/` — Contains `BaseTest.java` for browser lifecycle management (setup/teardown).
* `src/main/java/pages/` — Page Object classes containing locators and page-specific actions.
* `src/main/java/pages/menu/` — Navigation layer for DemoQA category menus.
* `src/test/java/tests/` — Test scenarios grouped by functional modules.

---

## 📋 Test Coverage
Automated scenarios are implemented for the following sections:
- **Elements:** Form completion (Text Box), Check Box tree interactions, and Radio Buttons.
- **Alerts, Frame & Windows:** Handling browser tabs, new windows, iFrames, and JS alerts (Simple, Timer, and Prompt).
- **Widgets:** Auto-complete inputs, slider control, and multi-level menu navigation.
- **Interactions:** Drag-and-Drop (implemented via built-in methods and mouse simulation) and Resizable elements.

---

## 🛠 Implementation Details
**Fluent Interface:** Methods are designed to be chainable, resulting in highly readable and concise test code.
