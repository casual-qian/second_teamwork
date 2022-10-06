
public class TestRand {
    public static void main(String[] args) {
        RandInfo rand = new RandInfo();
        Person person = new Person();

        for (int i = 1;i <= 10; i++){
            String familyName = rand.getFamilyName();
            String[] nameAndSex = rand.getNameAndSex(rand.getSex());
            String name = nameAndSex[0];
            String sex = nameAndSex[1];
            String id = rand.getId();
            int[] arr = rand.getsuccessandtotal();
            int success = arr[0];
            int total = arr[1];

            person.setName(familyName.concat(name));
            person.setSex(sex);
            person.setId(id);
            person.setSuccess(success);
            person.setTotal(total);
            person.setRate(total, success);
            System.out.println(person);
        }
    }
}