package ru.koval.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.koval.domain.Company;

public interface CompanyRepo extends JpaRepository<Company, Long> {

}
