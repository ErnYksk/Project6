package StepDefinitions;

import Pages.DialogContent;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.util.List;

public class DataTableSteps {

    DialogContent dc=new DialogContent();
    
    @And("Click on the element in the Dialog")
    public void clickOnTheElementInTheDialog(DataTable elemanlar) {
        List<String> listElemanlar= elemanlar.asList(String.class);

        for(String strButtonName : listElemanlar)
            dc.findAndClick(strButtonName);
    }


    @And("User sending the keys in Dialog content")
    public void userSendingTheKeysInDialogContent(DataTable elemanlar) {

        //ÇİFT BOYUTLU OLDUĞU İÇİN
        List<List<String>> listElemanlar= elemanlar.asLists(String.class);

        for(int i=0;i< listElemanlar.size() ; i++ )
            dc.findAndSend(listElemanlar.get(i).get(0), listElemanlar.get(i).get(1) );
        // eleman adı                    eleman değeri
    }


    @And("Click on the card module in US_{int}_{int}")
    public void clickOnTheCardModuleInUS__(DataTable elemanlar) {
        List<List<String>> listElemanlar= elemanlar.asLists(String.class);

        for(int i=0;i< listElemanlar.size() ; i++ )
            dc.findAndSend(listElemanlar.get(i).get(0), listElemanlar.get(i).get(1) );
        // eleman adı                    eleman değeri
    }

    @Then("Success message should be displayed")
    public void successMessageShouldBeDisplayed() {
        dc.findAndContainsText("verifyNoItem", "no items" );
    }

    @And("Click on the element in the  US_{int}_{int}")
    public void clickOnTheElementInTheUS__(DataTable elemanlar) {

        List<List<String>> listElemanlar= elemanlar.asLists(String.class);

        for(int i=0;i< listElemanlar.size() ; i++ )
            dc.findAndSend(listElemanlar.get(i).get(0), listElemanlar.get(i).get(1) );
        // eleman adı                    eleman değeri

    }
}

