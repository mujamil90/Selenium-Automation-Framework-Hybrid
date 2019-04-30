package com.ui.qa.genes.config;


import ru.qatools.properties.Property;
import ru.qatools.properties.PropertyLoader;
import ru.qatools.properties.Resource;

/***
 * 
 * @author Muzzamil
 * 
 * This class is responsible to load all configuration data from @zoladoConfig file. 
 *
 */

@Resource.Classpath("ZalandoConfig.properties")
public class ZalandoConfigReader 
{
	
	public ZalandoConfigReader()
	{
		PropertyLoader.newInstance().populate(this);
	}
	
	@Property(value = "Browser")
	private String Browser;
	
	@Property(value="BaseUrl")
	private String BaseUrl;
	
	@Property(value="Timeout")
	private int timeout;
	
	@Property(value="ImplicitWait")
	private int ImplicitWait;
	
	public String getBrowser() {
		return Browser;
	}

	public String getWebPortalUrl() {
		return BaseUrl;
	}

	public int getTimeout() {
		return timeout;
	}

	public int getImplicitWait() {
		return ImplicitWait;
	}

}
