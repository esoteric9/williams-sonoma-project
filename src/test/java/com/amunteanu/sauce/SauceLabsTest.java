package com.amunteanu.sauce;

import java.net.*;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.*;
import org.testng.annotations.*;

import com.amunteanu.helpers.*;
import com.amunteanu.sauce.exceptions.*;

public abstract class SauceLabsTest extends BasicTest {

	private Browser browser;

	private String username;

	private String accessKey;

	private WebDriver driver;

	private String version;

	private String platform;

	/**
	 * @param baseURL
	 */
	public SauceLabsTest(String baseURL) {
		super(baseURL);
	}

	public Browser getBrowser() {
		return this.browser;
	}

	public void setBrowser(Browser browser) {
		this.browser = browser;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAccessKey() {
		return this.accessKey;
	}

	public void setAccessKey(String accessKey) {
		this.accessKey = accessKey;
	}

	public String getVersion() {
		return this.version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getPlatform() {
		return this.platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public Object[][] config() {
		return new Object[][] { new Object[] { Browser.IE, "11", "Windows 8.1" },
				new Object[] { Browser.CHROME, "41", "Windows XP" }, new Object[] { Browser.SAFARI, "7", "OS X 10.9" },
				new Object[] { Browser.FIREFOX, "35", "Windows 7" } };
	}

	public Object[][] cred() {
		return new Object[][] { new Object[] { "amnteanu", "515bf3f0-3bb4-4f7a-8344-9dd2a532ab09" } };
	}

	@DataProvider
	public Object[][] dataProvider() {
		return DataHelper.joinData(cred(), config(), dp());
	}

	abstract public Object[][] dp();

	@Override
	@BeforeMethod(groups = "firefox")
	public void setupFirefox() {
	}

	@Override
	@BeforeMethod(groups = "chrome", enabled = false)
	public void setupChrome() {
	}

	@Override
	@BeforeMethod(groups = "ie", enabled = false)
	public void setupIE() {
	}

	public void preTest(String username, String accessKey, Browser browser, String version, String platform)
			throws BrowserNotSupportedBySauceLabsException {
		this.platform = platform;
		this.version = version;
		this.browser = browser;
		this.username = username;
		this.accessKey = accessKey;
		setDriver(setUpSpecDriver());
		getDriver().get(getBaseURL());
	}

	private WebDriver setUpSpecDriver() throws BrowserNotSupportedBySauceLabsException {
		DesiredCapabilities cap;
		switch (getBrowser()) {
		case IE:
			cap = DesiredCapabilities.internetExplorer();
			break;
		case FIREFOX:
			cap = DesiredCapabilities.firefox();
			break;
		case CHROME:
			cap = DesiredCapabilities.chrome();
			break;
		case SAFARI:
			cap = DesiredCapabilities.safari();
			break;
		default:
			throw new BrowserNotSupportedBySauceLabsException();
		}
		cap.setCapability("platform", this.platform);
		cap.setCapability("version", this.version);
		cap.setCapability("passed", true);
		String testName =
				getClass().getSimpleName() + "within" + getBrowser().toString().toLowerCase() + " on " + getPlatform();
		cap.setCapability("name", testName);
		URL url = null;
		try {
			url = new URL("http://" + this.username + ":" + this.accessKey + "@ondemand.saucelabs.com:80/wd/hub");
		} catch (MalformedURLException e) {
			System.out.println("Can not connect to Sauce Labs URL[" + "http://" + this.username + ":" + this.accessKey
					+ "@ondemand.saucelabs.com:80/wd/hub");
		}
		return new RemoteWebDriver(url, cap);
	}
}
