package org.mai.string;

import java.util.Arrays;
/**
 * 
 * Levenshtein Distance, based on dynamic programing.
 *
 */
public class LevenshteinDistanceV1 {

	public static int cal(char[] s, char[] t) {
		int sLen = s.length;
		int tLen = t.length;
		if (sLen == 0 || tLen == 0)
			return Math.max(sLen, tLen);

		int[][] dpMatrics = new int[sLen + 1][tLen + 1];
		// init
		for (int i = 1; i <= sLen; i++) {
			dpMatrics[i][0] = i;
		}

		for (int j = 1; j <= tLen; j++) {
			dpMatrics[0][j] = j;
		}

		for (int i = 1; i <= sLen; i++) {
			int vi = i - 1;
			for (int j = 1; j <= tLen; j++) {
				int vj = j - 1;
				//System.out.println(s[vi] + ":" + t[vj]);
				if (s[vi] == t[vj])
					dpMatrics[i][j] = dpMatrics[i - 1][j - 1];
				else {
					dpMatrics[i][j] = min(dpMatrics[i - 1][j] + 1,
							dpMatrics[i][j - 1] + 1,
							dpMatrics[i - 1][j - 1] + 1);
				}

			}
		}
		//System.out.println(Arrays.deepToString(dpMatrics));
		return dpMatrics[sLen][tLen];
	}

	private static int min(int i, int j, int k) {
		return Math.min(k, Math.min(i, j));
	}

}
