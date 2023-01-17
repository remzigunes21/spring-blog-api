package com.remzi.springblogapi;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableWebMvc

/// **** IoC Container içerisinde bulunan inject edilebilecek nesneler. Bu
/// nesnelere bean denilir. */
// @Component class seviyesinde kullanılır. Ve üzerine yazıldığı class ın IoC
// containerda bir referanse oluşturur.
// @Bean method seviyesinde kullanılır. Ve üzerine yazıldığı method için IoC
// containerda bir referanse oluşturur.Kendimizin yazmadığımız methodlar için
// kullnırız. Örneğin BcryptPasswordEncoder methodu gibi

//// @Qualifier ---> Eğer bir interfaceden 2 tane class implement ederse ve IoC
//// de birden fazla referans olursa spring bu referansları ayırt etmek için
//// @Qualifier anatosyonunu kullanır

//// @Primary ---> Eğer bir interfaceden 2 tane class implement ederse ve IoC
//// de birden fazla referans olursa spring öncelik olandan işlem yapar.

/*
 * ***Injection Yöntemleri
 * Field Injection //@Authovired ***Object oriented a uymadığı için tavsiye
 * edilmiyor.Unit testte sıkıntı çıkarır.Çünkü private methoda ulaşılamaz.
 * Setter // controller da Set edilen class methodunun üzerine @Authovired
 * eklenerek
 * Constructor //klasik constructor tanımı ile. Tavsiye edilen yöntem
 */

/***
 *** @Lazy kullanımı
 *       IoC containera eklenen bir class ın ihtiyaç duyulduğu anda çağrılması
 *       proje başladığı anda çağrılmaz.
 *       IoC containera eklenen bir method ın ihtiyaç duyulduğu anda çağrılması
 *       proje başladığı anda çağrılmaz.
 *       Injection yöntemlerine konulabiilir. İhtiyaç halinde instance ları
 *       çağırır.Ne zaman bir endpoint tekiklenen kadar o injection
 *       çalışmayacaktır.
 *       2 servis class birbiri içinde inject edilmeye çalışıldığında hata
 *       verir. Çünkü birisinin nesnesi oluşmadan birbirlerini inject
 *       gerçekleşmeye çalışıldığı için. Bu hatayı çözmek için ; birisini
 *       constructor parametresi önüne @Lazy yazılırsa hata giderilir.
 */

/***
 * ApplicationContext kullanımı
 * ApplicationContext interface'i Spring IoC Container'ı temsil eder.
 * ApplicationContext, nesnelerin(bean) oluşturulması, konfigüre edilmesi ve
 * noktalara bu nesnelerin atamakla(injection) sorumludur
 * Yani ApplicationContext'in ana görevi nesnelerimizin(bean) yönetimini
 * sağlamaktır.
 * 
 */

/***
 * @Scope Anotasyonu. 7 tanedir.
 *        1-)singleton (Varsayılan)-> Her bir IoC Container için sadece bir tane
 *        nesne
 *        oluştururlur.Bir classtan bir tane nesne oluşturulur
 *        Kullanım: @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE), @Scope("prototype")
 *        2-) "prototype"-> Her injection işleminde yeni nesne oluşturuluyor.
 *        Kullanım: @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE), @Scope("prototype")
 *        3-) "request"-> Her HTTP request'i için yeni bir nesne oluşturulur.
 *        Kullanım:@Sessionscope, @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE), @Scope("prototype")
 */

public class SpringBlogApiApplication {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBlogApiApplication.class, args);
	}

}
