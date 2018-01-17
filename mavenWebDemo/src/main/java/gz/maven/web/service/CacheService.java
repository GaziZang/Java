package gz.maven.web.service;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

/**
 * Created by gazizang on 17/8/29.
 */
public class CacheService {
    Cache<Long, Integer> cache = CacheBuilder.newBuilder().maximumSize(20000).build();
}
