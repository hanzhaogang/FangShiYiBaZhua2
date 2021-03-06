package cn.hzg1981.fangshiyibazhua;

public class InputData {
    private String[] city = new String[] {"北京","上海","天津","广州","深圳"};
    
    private String[][] district = new String[][] 
            {
                    { "东城区", "西城区", "朝阳区", "海淀区", "丰台区", "石景山区", "门头沟区","房山区", "通州区", "顺义区", "大兴区", "昌平区", 
                    	"平谷区", "怀柔区", "密云县","延庆县" },
                    { "长宁区", "静安区", "普陀区", "闸北区", "虹口区" },
                    { "和平区", "河东区", "河西区", "南开区", "河北区", "红桥区", "塘沽区", "汉沽区", "大港区","东丽区" },
                    {"海珠区","荔湾区","越秀区","白云区","萝岗区","天河区","黄埔区","花都区","从化市","增城市","番禺区","南沙区"}, //广州
                    {"宝安区","福田区","龙岗区","罗湖区","南山区","盐田区"}, //深圳
            };

    private String[][][] business_circle = new String[][][] 
            {
                    {   //北京
                        {"建国门","东单","东直门","交道口","安定门","和平里","崇文门","东花市","广渠门","左安门","天坛"},//东城
                        {"月坛","木樨地","前门","西直门","新街口","德胜门","六铺炕","地安门","车公庄","阜成门","金融街","官园","西四","西单",
                        	"马连道","广安门","长椿街","牛街","宣武门","陶然亭","右安门内"},//西城
                        {"北苑","亚运村","亚运村小营","奥林匹克公园","南沙滩","望京","大山子","酒仙桥","朝阳门","工体","安贞","惠新西街","芍药居",
                        	"太阳宫","西坝河","三元桥","国展","燕莎","东大桥","CBD","双井","大望路","北工大","十里河","十八里店","垡头","欢乐谷",
                        	"百子湾","豆各庄","劲松","潘家园","农展馆","红庙","甜水园","朝阳公园","石佛营","四惠","十里堡","甘露园","高碑店","朝青",
                        	"东坝","常营","定福庄","管庄","双桥","黄港","首都机场","马甸","团结湖","朝阳其他"},//朝阳
                        {"西二旗","西三旗","上地","马连洼","清河","圆明园","五道口","学院路","中关村","双榆树","知春路","西山","世纪城","四季青",
                        		"万柳","厂洼","紫竹桥","魏公村","苏州桥","皂君庙","石桥","小西天","北太平庄","牡丹园","二里庄","玉泉路","田村",
                        		"五棵松","定慧寺","公主坟","甘家口","军博","海淀其它","安宁庄","万寿路","西北旺","海淀北部新区"},//海淀
                        {"青塔","卢沟桥","五里店","北大地","看丹桥","科技园区","花乡","玉泉营","菜户营","丽泽","六里桥","方庄", 
                        		"蒲黄榆","木樨园","赵公口","刘家窑","宋家庄","成寿寺","西罗园","洋桥","大红门","草桥","马家堡","和义",
                        		"右安门外","角门","丰台其它"},//丰台
                        {"苹果园","杨庄","古城","八角","鲁谷","老山","石景山其它"},//石景山
                        {"无"},//门头沟
                        {"无"},//房山
                        {"无"},//通州
                        {"无"},//顺义
                        {"无"},//大兴
                        {"无"},//昌平
                        {"无"},//平谷
                        {"无"},//怀柔
                        {"无"},//密云
                        {"无"}//延庆
                    },
                    {    //上海
                        {"无"},
                        {"无"},
                        {"无"},
                        {"无"},
                        {"无"}
                    },
                    {    //天津
                        {"无"},
                        {"无"},
                        {"无"},
                        {"无"},
                        {"无"},
                        {"无"},
                        {"无"},
                        {"无"},
                        {"无"},
                        {"无"}
                    },
                    {    //广州
                        {"无"},{"无"},{"无"},{"无"},{"无"},{"无"},{"无"},{"无"},{"无"},{"无"}
                    },
                    {    //深圳
                    	
                    }
            };
    
    
    private String[] price = new String[] {
    		"不限","100万以下","100-150万","150-200万",
    		"200-250万","250-300万","300-500万","500-1000万","1000万以上"};
    
    private String[] acreage = new String[]{
    	    "不限","50平米以下","50-70平米","70-90平米","90-110平米",
    	    "110-130平米","130-150平米","150-200平米","200平米以上 "};

    private String[] room = new String[]{
    		"不限","开间","1室","2室","3室","4室","5室","5室以上"};
    
    public String[] getCity(){
	    return city;
    } 

    public String[][] getDistrict(){
	    return district;
    } 
   
    public String[][][] getBusiness_circle(){
	    return business_circle;
    } 

    public String[] getPrice(){
	    return price;
    } 

    public String[] getRoom(){
	    return room;
    } 
   
    public String[] getAcreage(){
	    return acreage;
    } 
}
