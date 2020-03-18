public static void main(String[] args) {
	int[] wallPositions1 = {1,2,4,7};
	int[] wallHeights1 = {4,6,8,11};
	int[] wallPositions2 = {1,3,7};
	int[] wallHeights2 = {4,3,3};
	System.out.println(getMaxHeight(wallPositions1, wallHeights1));
	System.out.println(getMaxHeight(wallPositions2, wallHeights2));
}

private static int getMaxHeight(int[] wallPositions, int[] wallHeights) {
	int res = 0;
	for(int i=1;i<wallPositions.length;i++) {
		int prevHeight = wallHeights[i-1], prevPosition = wallPositions[i-1];
		int curHeight = wallHeights[i], curPosition = wallPositions[i];
		if(curHeight > prevHeight && curPosition - prevPosition > 0)
			res = Math.max(curHeight - 1, res);
		else if(curHeight < prevHeight && curPosition - prevPosition > 0)
			res = Math.max(prevHeight - 1, res);
		else {
			res = Math.max(res, prevHeight + (curPosition - prevPosition)/2);
		}
	}
	return res;
}