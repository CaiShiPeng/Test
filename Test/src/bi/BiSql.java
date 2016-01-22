package bi;

//查询的sql技术验证
public class BiSql {
	public final static String SQL_FQZ_BASE = "SELECT * FROM ifre_fqz_info WHERE c_time>'2016-1-1' AND c_time <'2016-1-16'";
	public final static String SQL_FQZ_TotalNum = "SELECT COUNT(*) FROM ifre_fqz_info WHERE c_time>'2016-1-1' AND c_time <'2016-1-16'";
	public final static String SQL_FQZ_SCORENUM = "SELECT COUNT(*),riskRanking FROM ifre_fqz_info WHERE c_time>'2016-1-1' AND c_time <'2016-1-16' GROUP BY riskRanking";
	public final static String SQL_FQZ_AVGSCORE = "SELECT AVG(score_total) FROM ifre_fqz_info WHERE c_time>'2016-1-1' AND c_time <'2016-1-16'";
	public final static String SQL_FQZ_WARINGSCORENUM = "SELECT COUNT(*) FROM ifre_fqz_info WHERE c_time>'2016-1-1' AND c_time <'2016-1-16' AND firstProposal != '无'";
//	//计算中位数测试，其他的可以需要时完成
//	//7000条数据计算用时16秒
//	public final static String SQL_FQZ_MEDIANSCORE = "SELECT score_total Median FROM (SELECT a1.id, a1.score_total, COUNT(a1.score_total) Rank FROM (SELECT id,score_total FROM ifre_fqz_info WHERE c_time>'2016-1-1' AND c_time <'2016-1-16') a1, (SELECT id,score_total FROM ifre_fqz_info WHERE c_time>'2016-1-1' AND c_time <'2016-1-16') a2 WHERE a1.score_total < a2.score_total OR (a1.score_total=a2.score_total AND a1.id <= a2.id) GROUP BY a1.id, a1.score_total ORDER BY a1.score_total desc) a3 WHERE Rank = (SELECT (COUNT(*)+1) DIV 2 FROM (SELECT id,score_total FROM ifre_fqz_info WHERE c_time>'2016-1-1' AND c_time <'2016-1-16') t);";
//	//7000条数据计算用时42秒
//	public final static String SQL_FQZ_MEDIANSCORE2 = "SELECT avg(medianTemp) median FROM(SELECT id,avg(score_total) medianTemp FROM ( SELECT  e.id, e.score_total FROM (SELECT id,score_total FROM ifre_fqz_info WHERE c_time>'2016-1-1' AND c_time <'2016-1-16') e, (SELECT id,score_total FROM ifre_fqz_info WHERE c_time>'2016-1-1' AND c_time <'2016-1-16') d GROUP BY e.id, e.score_total HAVING sum(CASE WHEN e.score_total = d.score_total THEN 1 ELSE 0 END) >= abs(sum(sign(e.score_total - d.score_total))))t1 GROUP BY id)t2";
//	//鉴于数据量大时的中位数查询时间过长，建议使用逻辑控制来计算中位数，即分两步计算，第一步计算查询总数，第二步在使用limit计算
//	public final static String SQL_FQZ_MEDIANSCORE_STEP1 = "SELECT COUNT(*) FROM ifre_fqz_info WHERE c_time>'2016-1-1' AND c_time <'2016-1-16'";
//	public final static String SQL_FQZ_MEDIANSCORE_STEP2_JISHU = "SELECT avg(score_total) FROM ifre_fqz_info WHERE c_time>'2016-1-1' AND c_time <'2016-1-16' GROUP BY score_total LIMIT 4000,1";
//	public final static String SQL_FQZ_MEDIANSCORE_STEP2_OUSHU = "SELECT avg(score_total) FROM ifre_fqz_info WHERE c_time>'2016-1-1' AND c_time <'2016-1-16' GROUP BY score_total LIMIT 4000,2";
	public final static String SQL_FQZ_AVGRUNRULEPERCENT_DEVICE = "SELECT COUNT(*) FROM ifre_fqz_device WHERE f_id in (SELECT id FROM ifre_fqz_info WHERE c_time>'2016-1-1' AND c_time <'2016-1-16')";
	public final static String SQL_FQZ_AVGRUNRULEPERCENT_IDCARD = "SELECT COUNT(*) FROM ifre_fqz_idcard WHERE f_id in (SELECT id FROM ifre_fqz_info WHERE c_time>'2016-1-1' AND c_time <'2016-1-16')";
	public final static String SQL_FQZ_AVGRUNRULEPERCENT_MOBILE = "SELECT COUNT(*) FROM ifre_fqz_mobile WHERE f_id in (SELECT id FROM ifre_fqz_info WHERE c_time>'2016-1-1' AND c_time <'2016-1-16')";
	
	public final static String SQL_SQPF_BASE_U = "SELECT * FROM ifre_user_info WHERE c_time>'2016-1-1' AND c_time <'2016-1-16'";
	public final static String SQL_SQPF_BASE_C = "SELECT * FROM ifre_company_info WHERE c_time>'2016-1-1' AND c_time <'2016-1-16'";
	public final static String SQL_SQPF_TotalNum_U = "SELECT COUNT(*) FROM ifre_user_info WHERE c_time>'2016-1-1' AND c_time <'2016-1-16'";
	public final static String SQL_SQPF_TotalNum_C = "SELECT COUNT(*) FROM ifre_company_info WHERE c_time>'2016-1-1' AND c_time <'2016-1-16'";
	public final static String SQL_SQPF_SCORENUM_U = "SELECT COUNT(*),crate FROM ifre_user_info WHERE c_time>'2016-1-1' AND c_time <'2016-1-16' GROUP BY crate";
	public final static String SQL_SQPF_SCORENUM_C = "SELECT COUNT(*),crate FROM ifre_company_info WHERE c_time>'2016-1-1' AND c_time <'2016-1-16' GROUP BY crate";
	public final static String SQL_SQPF_AVGSCORE_U = "SELECT AVG(score) FROM ifre_user_info WHERE c_time>'2016-1-1' AND c_time <'2016-1-16'";
	public final static String SQL_SQPF_AVGSCORE_C = "SELECT AVG(score) FROM ifre_company_info WHERE c_time>'2016-1-1' AND c_time <'2016-1-16'";
	public final static String SQL_SQPF_MEDIANSCORE = "";
//	//只写了demo，具体的待完善
	public final static String SQL_SQPF_AVGPARAMETERPERCENT = "SELECT SUM(CASE WHEN id%2 = 1 AND gender IS NOT NULL THEN 1 ELSE 0 END) FROM ifre_user_info WHERE c_time>'2016-1-1' AND c_time <'2016-1-16'";
	
	public final static String SQL_WY_BASE = "SELECT * FROM ifre_apply_bill_info WHERE c_time>'2016-1-1' AND c_time <'2016-1-16'";
	public final static String SQL_WY_TotalNum = "SELECT COUNT(*) FROM ifre_apply_bill_info WHERE c_time>'2016-1-1' AND c_time <'2016-1-16'";
	public final static String SQL_WY_SCORENUM = "SELECT COUNT(*),crate FROM ifre_apply_bill_info WHERE c_time>'2016-1-1' AND c_time <'2016-1-16' GROUP BY crate";
	public final static String SQL_WY_AVGSCORE = "SELECT AVG(score) FROM ifre_apply_bill_info WHERE c_time>'2016-1-1' AND c_time <'2016-1-16'";
	public final static String SQL_WY_MEDIANSCORE = "";
//	//只写了demo，具体的待完善
	public final static String SQL_WY_AVGPARAMETERPERCENT = "SELECT SUM(CASE WHEN id%2 = 1 AND gender IS NOT NULL THEN 1 ELSE 0 END) FROM ifre_apply_bill_info WHERE c_time>'2016-1-1' AND c_time <'2016-1-16'";
	public final static String SQL_WY_AVGWYPERCENT = "SELECT AVG(wychance) FROM ifre_apply_bill_info WHERE c_time>'2016-1-1' AND c_time <'2016-1-16'";
	
}
