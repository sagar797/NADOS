public class arrange_buildings {
    public static void main(String[] args) {
        int n = 6;

        long building = 1;
        long space = 1;

        for (int i = 2; i <= n; i++) {
            long newBuilding = space;
            long newSpace = building + space;

            building = newBuilding;
            space = newSpace;
        }

        long result = (building + space) * (building + space);

        System.out.println(result);
    }
}
