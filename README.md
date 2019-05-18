# cs307Project 新增的功能及定义（2019/05/17)

## Dao相关

1. 后台请求数据库随机选取14个商品和服务（定义在GoodDao）

```java
List<Good> queryGoodsRandom();
List<Good> queryServersRandom();
```

2. 得到某个人的聊天记录清单（默认按照时间逆序）（定义在MessageDao）

```java
List<Message> queryMessageList(Integer user_id);
```

3. 得到某个人的评价记录（默认按照时间逆序）（定义在CommentDao）

```java
List<Comment> queryComments(Integer user_id);
```

## 搜索相关

定义在`tools.Search`

1. 对关键词搜索（默认按匹配度排序）

   每一页返回20条，如果page小于1则返回前2000条

   ```java
   List<Good> search(List<String> keywords, Integer page);
   ```

2. 分类对关键词搜索（默认按匹配度排序）

   每一页返回20条，如果page小于1则返回前2000条

   ```java
   List<Good> search(List<String> keywords,Integer tag,Integer page);
   ```

3. 对搜索结果按多种指标排序，传入一个String类型表示是按照时间还是按照价格排序，boolean值表示是否按照降序。low和up表示商品价格的上界和下届（如果传入两个负数，默认值是0和0x3f3f3f3f）
   带有tag的与不带tag的实现基本一致(keywords后面多了一个tag参数)，这里以不带tag的为例：
   ```java
   public List<Good> search(List<String> keywords, Integer page, String sortKey,boolean decrease,float low,float up);
   ```
   

