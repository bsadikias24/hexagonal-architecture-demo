import archunit.HexagonalArchitecture;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

class DependencyRuleTests {

	@Test
	void validateRegistrationContextArchitecture() {
		HexagonalArchitecture.boundedContext("com.hexagonal.user")

				.withDomainLayer("model")

				.withAdaptersLayer("adapter")
				.incoming("in.web")
				.outgoing("out.persistence")
				.and()

				.withApplicationLayer("application")
				.services("service")
				.incomingPorts("port.in")
				.outgoingPorts("port.out")
				.and()

				.withConfiguration("configuration")
				.check(new ClassFileImporter()
						.importPackages("com.hexagonal..."));
	}

	@Test
	void testPackageDependencies() {
		noClasses()
				.that()
				.resideInAPackage("com.hexagonal.domain..")
				.should()
				.dependOnClassesThat()
				.resideInAnyPackage("com.hexagonal.application..")
				.check(new ClassFileImporter()
						.importPackages("com.hexagonal.."));
	}

}
