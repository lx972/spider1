package cn.kgc.model;

import java.io.Serializable;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author lx
 *    Article实体类
 * @date 2019-12-22 16:59:59
 */
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class ArticleEntity implements Serializable{

	  private static final long serialVersionUID = 1L;
	
	/**
	* id
	*/
	  private Integer id;
	/**
	* 唯一标识该章节，md5加密后的title
	*/
	  private String md5Key;
	/**
	* 章节标题
	*/
	  private String title;
	/**
	* 章节内容
	*/
	  private String content;

	  /**
	   * 设置：id
	   */
	  public void setId(Integer id) {
		  this.id = id;
	  }
	  /**
	   * 获取：id
	   */
	  public Integer getId() {
	   	  return id;
	  }
	  /**
	   * 设置：唯一标识该章节，md5加密后的title
	   */
	  public void setMd5Key(String md5Key) {
		  this.md5Key = md5Key;
	  }
	  /**
	   * 获取：唯一标识该章节，md5加密后的title
	   */
	  public String getMd5Key() {
	   	  return md5Key;
	  }
	  /**
	   * 设置：章节标题
	   */
	  public void setTitle(String title) {
		  this.title = title;
	  }
	  /**
	   * 获取：章节标题
	   */
	  public String getTitle() {
	   	  return title;
	  }
	  /**
	   * 设置：章节内容
	   */
	  public void setContent(String content) {
		  this.content = content;
	  }
	  /**
	   * 获取：章节内容
	   */
	  public String getContent() {
	   	  return content;
	  }

	 
	  @Override
	  public String toString() {
		  return  ReflectionToStringBuilder.toString(this);
	  }

}
