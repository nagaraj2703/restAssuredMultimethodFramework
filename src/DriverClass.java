import java.io.IOException;

import TestClassPackage.get_tc_1;
import TestClassPackage.get_tc_2;
import TestClassPackage.post_tc_1;

public class DriverClass {

	public static void main(String[] args) throws IOException {
		post_tc_1.execute1();
		get_tc_1.execute2();
		get_tc_2.execute3();

	}

}
