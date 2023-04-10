package string;

public class CompareVersion {
    public int compareVersion(String version1, String version2) {
        // skip validating parameters
        String[] versionArr1 = version1.split("\\.");
        String[] versionArr2 = version2.split("\\.");
        int len = Math.max(versionArr1.length, versionArr2.length);
        int v1, v2;
        for (int i = 0; i < len; i++) {
            // length validate
            if (versionArr1.length <= i) {
                v1 = 0;
            } else {
                v1 = Integer.valueOf(versionArr1[i]);
            }

            if (versionArr2.length <= i) {
                v2 = 0;
            } else {
                v2 = Integer.valueOf(versionArr2[i]);
            }

            if (v1 == v2) {
                continue;
            } else if (v1 > v2) {
                return 1;
            } else {
                return -1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        CompareVersion main = new CompareVersion();
        String version1, version2;
        int expected, actual;

        version1 = "0.1";
        version2 = "1.1";
        expected = -1;
        actual = main.compareVersion(version1, version2);
        System.out.println(actual);

        version1 = "1.0.1";
        version2 = "1";
        expected = 1;
        actual = main.compareVersion(version1, version2);
        System.out.println(actual);

        version1 = "0.1";
        version2 = "1.1";
        expected = -1;
        actual = main.compareVersion(version1, version2);
        System.out.println(actual);
    }
}
