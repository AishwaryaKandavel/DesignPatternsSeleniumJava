package designpatternseleniumjava.tests;

import org.testng.annotations.Test;

import designpatternseleniumjava.basetests.BaseTest;

public class UITest extends BaseTest{
	@Test
	public void uiTest() {
		System.out.println(travelApp.getFooterNav().getFooterFlightAttribute());
        System.out.println(travelApp.getNavigationBar().getHeaderFlightAttribute());
        System.out.println(travelApp.getFooterNav().getLinksCount());
        System.out.println(travelApp.getNavigationBar().getLinksCount());
	}
}
