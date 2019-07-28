package com.arc.context.config.datasource;

/**
 * Context holder of the dynamic data source.
 * Determine the dynamic data source by the key {@link DynamicDataSourceType}.
 *
 * @author lamymay@outlook.com
 */
public class DynamicDataSourceHolder {

    private static final ThreadLocal<DynamicDataSourceType> contextHolder = new ThreadLocal<DynamicDataSourceType>();

    public static void setDataSourceType(DynamicDataSourceType type) {
        contextHolder.set(type);
    }

    /**
     * 获取key值 以获取DS
     *
     * @return
     */
    public static DynamicDataSourceType getDataSourceType() {
//        return contextHolder.get() == null ? DynamicDataSourceType.WRITE : contextHolder.get();

        DynamicDataSourceType dataSourceType = null;
        if (contextHolder.get() == null) {
            dataSourceType = DynamicDataSourceType.WRITE;
        } else {
            dataSourceType = contextHolder.get();
        }
        System.out.println(dataSourceType);
        System.out.println(dataSourceType);
        System.out.println(dataSourceType);
        return dataSourceType;
    }

    public static void removeDataSourceType() {
        contextHolder.remove();
    }
}
