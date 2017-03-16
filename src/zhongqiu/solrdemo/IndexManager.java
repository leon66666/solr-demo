package zhongqiu.solrdemo;

import java.io.IOException;

import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.common.SolrInputDocument;

public class IndexManager {

	public static void main(String[] args) throws Exception {
		insertAndUpdateIndex();
	}

	public static void insertAndUpdateIndex() throws Exception {
		// 创建HttpSolrServer
		HttpSolrServer server = new HttpSolrServer("http://ceshi.niuguwang.com:8203/solr");
		// 创建Document对象
		SolrInputDocument doc = new SolrInputDocument();
		doc.addField("id", "c001");
		doc.addField("name", "solr test111");
		// 将Document对象添加到索引库
		server.add(doc);
		// 提交
		server.commit();
	}

	public static void deleteIndex() throws Exception {
		// 创建HttpSolrServer
		HttpSolrServer server = new HttpSolrServer("http://ceshi.niuguwang.com:8203/solr");

		// 根据指定的ID删除索引
		// server.deleteById("c001");

		// 根据条件删除
		server.deleteByQuery("id:c001");

		// 删除全部（慎用）
		// server.deleteByQuery("*:*");

		// 提交
		server.commit();
	}
}
