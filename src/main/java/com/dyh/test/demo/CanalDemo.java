//package com.dyh.test.demo;
//
//import javafx.event.EventType;
//import org.apache.commons.lang3.StringUtils;
//import sun.plugin2.message.Message;
//
//import java.io.UnsupportedEncodingException;
//import java.security.KeyStore;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.List;
//
//import static sun.util.locale.LanguageTag.SEP;
//
///**
// * description: Canal demo
// * author: dyh
// * date: 2021/11/29 10:25
// */
//public class CanalDemo {
//
//    public void process() {
//        // 每批次处理的条数
//        int batchSize = 1024;
//        while (running) {
//            try {
//                // 连上Canal服务
//                connector.connect();
//                // 订阅数据（比如某个表）
//                connector.subscribe("table_xxx");
//                while (running) {
//                    // 批量获取数据变更记录
//                    Message message = connector.getWithoutAck(batchSize);
//                    long batchId = message.getId();
//                    int size = message.getEntries().size();
//                    if (batchId == -1 || size == 0) {
//                        // 非预期情况，需做异常处理
//                    } else {
//                        // 打印数据变更明细
//                        printEntry(message.getEntries());
//                    }
//
//                    if (batchId != -1) {
//                        // 使用batchId做ack操作：表明该批次处理完成，更新Canal侧消费进度
//                        connector.ack(batchId);
//                    }
//                }
//            } catch (Throwable e) {
//                logger.error("process error!", e);
//                try {
//                    Thread.sleep(1000L);
//                } catch (InterruptedException e1) {
//                    // ignore
//                }
//
//                // 处理失败, 回滚进度
//                connector.rollback();
//            } finally {
//                // 断开连接
//                connector.disconnect();
//            }
//        }
//    }
//
//    private void printEntry(List<KeyStore.Entry> entrys) {
//        for (KeyStore.Entry entry : entrys) {
//            long executeTime = entry.getHeader().getExecuteTime();
//            long delayTime = new Date().getTime() - executeTime;
//            Date date = new Date(entry.getHeader().getExecuteTime());
//            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//
//            // 只关心数据变更的类型
//            if (entry.getEntryType() == EntryType.ROWDATA) {
//                RowChange rowChange = null;
//                try {
//                    // 解析数据变更对象
//                    rowChange = RowChange.parseFrom(entry.getStoreValue());
//                } catch (Exception e) {
//                    throw new RuntimeException("parse event has an error , data:" + entry.toString(), e);
//                }
//
//                EventType eventType = rowChange.getEventType();
//
//                logger.info(row_format,
//                        new Object[] { entry.getHeader().getLogfileName(),
//                                String.valueOf(entry.getHeader().getLogfileOffset()), entry.getHeader().getSchemaName(),
//                                entry.getHeader().getTableName(), eventType,
//                                String.valueOf(entry.getHeader().getExecuteTime()), simpleDateFormat.format(date),
//                                entry.getHeader().getGtid(), String.valueOf(delayTime) });
//
//                // 不关心查询，和DDL变更
//                if (eventType == EventType.QUERY || rowChange.getIsDdl()) {
//                    logger.info("ddl : " + rowChange.getIsDdl() + " ,  sql ----> " + rowChange.getSql() + SEP);
//                    continue;
//                }
//
//                for (RowData rowData : rowChange.getRowDatasList()) {
//                    if (eventType == EventType.DELETE) {
//                        // 数据变更类型为 删除 时，打印变化前的列值
//                        printColumn(rowData.getBeforeColumnsList());
//                    } else if (eventType == EventType.INSERT) {
//                        // 数据变更类型为 插入 时，打印变化后的列值
//                        printColumn(rowData.getAfterColumnsList());
//                    } else {
//                        // 数据变更类型为 其他（即更新） 时，打印变化前后的列值
//                        printColumn(rowData.getBeforeColumnsList());
//                        printColumn(rowData.getAfterColumnsList());
//                    }
//                }
//            }
//        }
//    }
//
//    // 打印列值
//    private void printColumn(List<Column> columns) {
//        for (Column column : columns) {
//            StringBuilder builder = new StringBuilder();
//            try {
//                if (StringUtils.containsIgnoreCase(column.getMysqlType(), "BLOB")
//                        || StringUtils.containsIgnoreCase(column.getMysqlType(), "BINARY")) {
//                    // get value bytes
//                    builder.append(column.getName() + " : "
//                            + new String(column.getValue().getBytes("ISO-8859-1"), "UTF-8"));
//                } else {
//                    builder.append(column.getName() + " : " + column.getValue());
//                }
//            } catch (UnsupportedEncodingException e) {
//            }
//            builder.append("    type=" + column.getMysqlType());
//            if (column.getUpdated()) {
//                builder.append("    update=" + column.getUpdated());
//            }
//            builder.append(SEP);
//            logger.info(builder.toString());
//        }
//    }
//}
