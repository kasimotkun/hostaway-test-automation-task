import Base.BaseTest;
import Pages.AllListingsPage;
import Pages.FilterForm;
import Pages.SearchPage;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;

@Feature("Assessment Tests")
public class AssessmentTests extends BaseTest {

    @Test(description = "Verify Filter Form Fields")
    public void TC0001() {

        SearchPage searchPage;
        FilterForm filterForm;

        searchPage =homePage
                            .search();
        filterForm=searchPage
                            .goToFilterForm();
        filterForm.checkFilterForm();
    }

    @Test(description = "Verify All Listing Page Items Count")
    public void TC0002() {

        AllListingsPage allListingsPage;

        allListingsPage=homePage
                                .goToAllListingsPage();
        allListingsPage.checkAllListingsCount();
    }



}
