package bi;
import java.util.Date;
import java.util.List;

public interface BIQuery {
	
	List<IfreUserLogin> getIfreUserLoginList(String userName);
	
	//查询原始数据功能先不开发
	FqzScoreInfo getBaseFqzScoreInfo(CheckBiQuery checkBiQuery); 
	SqpfScoreInfo getBaseSqpfScoreInfo(CheckBiQuery checkBiQuery); 
	WyScoreInfo getBaseWyScoreInfo(CheckBiQuery checkBiQuery); 
	
	int getFqzScoerNum(CheckBiQuery checkBiQuery);
	List<FqzScoreQueryInfo> getFqzScoreQueryInfo(CheckBiQuery checkBiQuery);
	List<SqpfScoreQueryInfo> getSqpfScoreQueryInfo(CheckBiQuery checkBiQuery);
	List<WyScoreQueryInfo> getWyScoreQueryInfo(CheckBiQuery checkBiQuery);

}

class IfreUserLogin{
	int id;
	String name;
}

class CheckBiQuery{
	int[] ifreUserLoginId;
	Date startDate;
	Date endDate;
}

class FqzScoreInfo{
	int id;
	int score;
	String fqzInfo;
}
//step1定义
//step2技术验证
//step3输入
//step4公式
//step5输出
class FqzScoreQueryInfo{
	//查询量&客户量&重复查询率
	int scoreTotalNum;
	//风险等级数量&风险等级占比
	int score低风险Num;
	int score低风险Percent;
	int score高风险Num;
	int score高风险Percent;
	int score欺诈Num;
	int score欺诈Percent;
	//平均分
	double avgScore;
	//风险提示率
	int warningScoreNum;
	double warningScorePercent;
	//执行规则率
	double avgRunRuleNum;
	double avgRunRulePercent;
}

class SqpfScoreInfo{
	int id;
	int score;
	String sqpfInfo;
}

class SqpfScoreQueryInfo{
	//查询量&客户量&重复查询率
	int scoreTotalNum;
	//风险等级数量&风险等级占比
	int scoreANum;
	int scoreAPercent;
	int scoreBNum;
	int scoreBPercent;
	int scoreCNum;
	int scoreCPercent;
	int scoreDNum;
	int scoreDPercent;
	int scoreENum;
	int scoreEPercent;
	//平均分
	double avgScore;
	//中位数
	int medianScore;
	//完整度
	double avgParameterPercent;
}

class WyScoreInfo{
	int id;
	int score;
	String wyInfo;
}

class WyScoreQueryInfo{
	// 查询量&客户量&重复查询率
	int scoreTotalNum;
	// 风险等级数量&风险等级占比
	int scoreANum;
	int scoreAPercent;
	int scoreBNum;
	int scoreBPercent;
	int scoreCNum;
	int scoreCPercent;
	int scoreDNum;
	int scoreDPercent;
	int scoreENum;
	int scoreEPercent;
	int scoreFNum;
	int scoreFPercent;
	int scoreGNum;
	int scoreGPercent;
	//平均分
	double avgScore;
	//中位数
	int medianScore;
	//完整度
	double avgParameterPercent;
	//平均违约率（该值为模型计算值）
	double avgWyPercent;
}