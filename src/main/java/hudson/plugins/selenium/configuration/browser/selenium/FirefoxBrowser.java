package hudson.plugins.selenium.configuration.browser.selenium;

import hudson.Extension;
import hudson.model.Computer;
import hudson.plugins.selenium.process.SeleniumRunOptions;

import java.util.List;

import org.kohsuke.stapler.DataBoundConstructor;
import org.kohsuke.stapler.export.Exported;

public class FirefoxBrowser extends SeleniumBrowser {

    /**
	 * 
	 */
    private static final long serialVersionUID = 1180910636911313608L;

    transient final protected String paramBinaryPath = "firefox_binary";

    private String binaryPath;

    @DataBoundConstructor
    public FirefoxBrowser(int maxInstances, String version, String binaryPath) {
        super(maxInstances, version, "*firefox");
        this.binaryPath = binaryPath;
    }

    @Exported
    public String getBinaryPath() {
        return binaryPath;
    }

    @Override
    public List<String> initBrowserOptions(Computer c, SeleniumRunOptions options) {
        List<String> args = super.initBrowserOptions(c, options);
        combine(args, paramBinaryPath, binaryPath);
        return args;
    }

    @Extension
    public static class DescriptorImpl extends SeleniumBrowserDescriptor {

        public int getMaxInstances() {
            return 5;
        }

        @Override
        public String getDisplayName() {
            return "Firefox";
        }

    }
}
