package pl.coderslab.Zadanie_2;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/buy-sweater.feature",
        plugin = {"pretty","html:out"},tags = "@shop")

public class BuyTest {
}