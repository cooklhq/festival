package cn.bdqfork.model.bean;

import javax.inject.Named;
import javax.inject.Singleton;

/**
 * @author fbw
 * @since 2020/1/5
 */

@Singleton
@Named("singletonBeanServiceImpl")
public class SingletonSingletonBeanServiceImpl implements SingletonBeanService {


    private SingletonBeanDao singletonBeanDao;


}
