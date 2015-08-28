package hm.orz.sumpic.samples.propertiesloadforbean;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class SettingsTest {
	@Test
	public void 設定クラスと対をなすプロパティファイルをリソースのディレクトリに有ればセットしたBeanを取得できる() {
		// act
		Settings actual = Settings.get();
		// assertion
		assertThat(actual.getDriver(), is("driver"));
	}
}
