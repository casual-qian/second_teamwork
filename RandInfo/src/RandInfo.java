
import java.util.Random;

public class RandInfo {
    String familyName1 = "��Ǯ��������֣��������������������������ʩ�ſײ��ϻ���κ�ս���л����ˮ�����˸��ɷ�����³Τ������ﻨ������Ԭ����ʷ�Ʒ��Ѧ�׺����������ޱϺ�����������ʱ�����뿵����Ԫ������ƽ"
            + "�ƺ�������Ҧ��տ����ë����ױ���갼Ƴɴ���é���ܼ�������ף��������ϯ����ǿ��·¦Σ��ͯ�չ�÷ʢ�ֵ�����������Ĳ����������¬Ī���Ѹɽ�Ӧ�ڶ������������������ʯ�޼�"
            + "�����ϻ���½����������ҷ��Ǵ������ɾ����ڽ��͹�����ɽ�ȳ������������������ղ����Ҷ��˾�����ǲ�˫��ݷ���̼�Ƚ�׹�ţ��ͨ���༽��ũ��ׯ������ϰ������Ÿ��վӺⲽ����������Ķ�Ź�����غ��θ��滸��������";
    String girlName = "���Ӣ���������Ⱦ���������֥��Ƽ�����ҷ���ʴ��������÷���������滷ѩ�ٰ���ϼ����ݺ�����𷲼Ѽ�������������Ҷ�������������ɺɯ������ٻ�������ӱ¶������������Ǻɵ���ü������ޱݼ���Է�ܰ�������԰��ӽ�������ع���ѱ�ˬ������ϣ����Ʈ�����������������������ܿ�ƺ������˿ɼ���Ӱ��֦˼��";
    String boyName = "ΰ�����㿡��ǿ��ƽ�����Ļ�������������־��������ɽ�ʲ���������Ԫȫ��ʤѧ��ŷ���������ɱ�˳���ӽ��β��ɿ��ǹ���ﰲ����ï�����м�ͱ벩���Ⱦ�����׳��˼Ⱥ���İ�����ܹ����ƺ���������ԣ���ܽ���������ǫ�����֮�ֺ��ʲ����������������ά�������������󳿳�ʿ�Խ��������׵���ʱ̩ʢ��衾��ڲ�����ŷ纽��";

    //�����������
    public String getFamilyName() {
        String str = "";
        int strLen =familyName1.length();
        int index = new Random().nextInt(strLen);
            str = String.valueOf(familyName1.charAt(index));
        return str;
    }

    //��������Ա�
    public String getSex() {
        int randNum = new Random().nextInt(2) + 1;
        return randNum == 1 ? "��" : "Ů";
    }

    //�����Ա������������
    public String[] getNameAndSex(String sex) {
        String[] nameSex = new String[2];
        int randNum = new Random().nextInt(2) + 1;
        int strLen = sex.equals("��") ? boyName.length() : girlName.length();
        int index = (randNum & 1) == 0 ? new Random().nextInt(strLen - 1) :
                new Random().nextInt(strLen);
        nameSex[0] = sex.equals("��") ? boyName.substring(index, index + randNum) :
                girlName.substring(index, index + randNum);
        nameSex[1] = sex.equals("��") ? "��" : "Ů";
        return nameSex;
    }
    
    //�������ѧ��
    public String getId() {
    	String id = "03200";
    	int num = new Random().nextInt(3)+1;
    	String str1 = ""+num;
    	num = new Random().nextInt(700)+100;
    	String str2 = ""+num;
    	id = id+str1+str2;
    	return id;
    }
    
    //���������Ч�ܴ�������Ч����
    public int[] getsuccessandtotal() {
    	int[] example = new int[2];
    	example[1] = new Random().nextInt(15)+1;		//�����ܴ���
    	example[0] = example[1]-new Random().nextInt(3)+1;//������Ч����
    	return example;
    }
}