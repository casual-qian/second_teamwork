
import java.util.Random;

public class RandInfo {
    String familyName1 = "赵钱孙李周吴郑王冯陈褚卫蒋沈韩杨朱秦尤许何吕施张孔曹严华金魏陶姜戚谢邹喻水云苏潘葛奚范彭郎鲁韦昌马苗凤花方俞任袁柳鲍史唐费岑薛雷贺倪汤滕殷罗毕郝邬安常乐于时傅卞齐康伍余元卜顾孟平"
            + "黄和穆萧尹姚邵湛汪祁毛禹狄米贝明臧计成戴宋茅庞熊纪舒屈项祝董粱杜阮席季麻强贾路娄危江童颜郭梅盛林刁钟徐邱骆高夏蔡田胡凌霍万柯卢莫房缪干解应宗丁宣邓郁单杭洪包诸左石崔吉"
            + "龚程邢滑裴陆荣翁荀羊甄家封芮储靳邴松井富乌焦巴弓牧隗山谷车侯伊宁仇祖武符刘景詹束龙叶幸司韶黎乔苍双闻莘劳逄姬冉宰桂牛寿通边燕冀尚农温庄晏瞿茹习鱼容向古戈终居衡步都耿满弘国文东殴沃曾关红游盖益桓公晋楚闫";
    String girlName = "秀娟英华慧巧美娜静淑惠珠翠雅芝玉萍红娥玲芬芳燕彩春菊兰凤洁梅琳素云莲真环雪荣爱妹霞香月莺媛艳瑞凡佳嘉琼勤珍贞莉桂娣叶璧璐娅琦晶妍茜秋珊莎锦黛青倩婷姣婉娴瑾颖露瑶怡婵雁蓓纨仪荷丹蓉眉君琴蕊薇菁梦岚苑婕馨瑗琰韵融园艺咏卿聪澜纯毓悦昭冰爽琬茗羽希宁欣飘育滢馥筠柔竹霭凝晓欢霄枫芸菲寒伊亚宜可姬舒影荔枝思丽";
    String boyName = "伟刚勇毅俊峰强军平保东文辉力明永健世广志义兴良海山仁波宁贵福生龙元全国胜学祥才发武新利清飞彬富顺信子杰涛昌成康星光天达安岩中茂进林有坚和彪博诚先敬震振壮会思群豪心邦承乐绍功松善厚庆磊民友裕河哲江超浩亮政谦亨奇固之轮翰朗伯宏言若鸣朋斌梁栋维启克伦翔旭鹏泽晨辰士以建家致树炎德行时泰盛雄琛钧冠策腾楠榕风航弘";

    //随机生成姓氏
    public String getFamilyName() {
        String str = "";
        int strLen =familyName1.length();
        int index = new Random().nextInt(strLen);
            str = String.valueOf(familyName1.charAt(index));
        return str;
    }

    //随机生成性别
    public String getSex() {
        int randNum = new Random().nextInt(2) + 1;
        return randNum == 1 ? "男" : "女";
    }

    //根据性别随机生成名字
    public String[] getNameAndSex(String sex) {
        String[] nameSex = new String[2];
        int randNum = new Random().nextInt(2) + 1;
        int strLen = sex.equals("男") ? boyName.length() : girlName.length();
        int index = (randNum & 1) == 0 ? new Random().nextInt(strLen - 1) :
                new Random().nextInt(strLen);
        nameSex[0] = sex.equals("男") ? boyName.substring(index, index + randNum) :
                girlName.substring(index, index + randNum);
        nameSex[1] = sex.equals("男") ? "男" : "女";
        return nameSex;
    }
    
    //随机生成学号
    public String getId() {
    	String id = "03200";
    	int num = new Random().nextInt(3)+1;
    	String str1 = ""+num;
    	num = new Random().nextInt(700)+100;
    	String str2 = ""+num;
    	id = id+str1+str2;
    	return id;
    }
    
    //随机生成有效总次数和有效次数
    public int[] getsuccessandtotal() {
    	int[] example = new int[2];
    	example[1] = new Random().nextInt(15)+1;		//生成总次数
    	example[0] = example[1]-new Random().nextInt(3)+1;//生成有效次数
    	return example;
    }
}