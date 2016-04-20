package soundsystem.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import soundsystem.CompactDiscConfig;

@Configuration
@Import({CompactDiscConfig.class, MediaPlayerConfig.class})
public class SoundSystemConfig {
}
