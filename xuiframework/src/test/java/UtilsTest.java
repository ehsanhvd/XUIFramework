import com.tpa.xuiframework.utils.XUtil;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UtilsTest {

    @Test
    public void telValidationTest(){
        assertTrue(XUtil.Companion.isValidIranTel("09363109889"));
        assertFalse(XUtil.Companion.isValidIranTel("+989363109889"));
        assertFalse(XUtil.Companion.isValidIranTel("9363109889"));
        assertFalse(XUtil.Companion.isValidIranTel("23424"));
        assertFalse(XUtil.Companion.isValidIranTel("09"));
        assertFalse(XUtil.Companion.isValidIranTel("09abcdfgsr"));
        assertFalse(XUtil.Companion.isValidIranTel("0936310988a"));
        assertFalse(XUtil.Companion.isValidIranTel("0"));
        assertFalse(XUtil.Companion.isValidIranTel("sdffdgh"));
        assertFalse(XUtil.Companion.isValidIranTel(""));
    }
}
