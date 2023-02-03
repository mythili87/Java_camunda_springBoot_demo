package com.example.workflow;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements JavaDelegate {

  public static void main(String... args) {
    SpringApplication.run(Application.class, args);
  }

  @Override
  public void execute(DelegateExecution delegateExecution) throws Exception {

    System.out.println("\n\n\n\n\n\nJava Delegate Service Task executed successfully\n\n\n\n\n\n");

    ChromeOptions options = new ChromeOptions();
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver(options);
    driver.manage().deleteAllCookies();
    driver.manage().window().maximize();
    driver.get("https://www.google.com");

    System.out.println(driver.getTitle() + "n\n\n\n\n\n");

  }
}