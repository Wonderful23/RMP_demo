package ty0207.example.demo.serviceimpl;

import java.io.Serializable;
import java.util.Objects;
import javax.annotation.Resource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;
import org.springframework.stereotype.Service;
import ty0207.example.demo.service.IDService;

@Service
public class IDServiceImpl implements IDService {

  @Resource
  private RedisTemplate<String, Serializable> redisTemplate;

  @Override
  public long generate(String key) {
    RedisAtomicLong counter = new RedisAtomicLong(key,
        Objects.requireNonNull(redisTemplate.getConnectionFactory()));
    return counter.incrementAndGet();
  }
}
