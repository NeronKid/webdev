package com.serving.accounting.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.serving.accounting.models.Role;
import com.serving.accounting.models.UserInfo;
import com.serving.accounting.repos.UserRepository;
import com.serving.accounting.service.UserService;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
	 private final UserRepository repository;

	    /**
	     * Сохранение пользователя
	     *
	     * @return сохраненный пользователь
	     */
	    public UserInfo save(UserInfo user) {
	        return repository.save(user);
	    }
	    
	    /**
	     * Создание пользователя
	     *
	     * @return созданный пользователь
	     */
	    public UserInfo create(UserInfo user) {
	        if (repository.existsByUsername(user.getUsername())) {
	            // Заменить на свои исключения
	            throw new RuntimeException("Пользователь с таким именем уже существует");
	        }

	        if (repository.existsByEmail(user.getEmail())) {
	            throw new RuntimeException("Пользователь с таким email уже существует");
	        }

	        return save(user);
	    }

	    /**
	     * Получение пользователя по имени пользователя
	     *
	     * @return пользователь
	     */
	    public UserInfo getByUsername(String username) {
	        return repository.findByUsername(username)
	                .orElseThrow(() -> new UsernameNotFoundException("Пользователь не найден"));

	    }

	    /**
	     * Получение пользователя по имени пользователя
	     * <p>
	     * Нужен для Spring Security
	     *
	     * @return пользователь
	     */
	    public UserDetailsService userDetailsService() {
	        return this::getByUsername;
	    }

	    /**
	     * Получение текущего пользователя
	     *
	     * @return текущий пользователь
	     */
	    public UserInfo getCurrentUser() {
	        // Получение имени пользователя из контекста Spring Security
	        String username = SecurityContextHolder.getContext().getAuthentication().getName();
	        return getByUsername(username);
	    }


	    /**
	     * Выдача прав администратора текущему пользователю
	     * <p>
	     * Нужен для демонстрации
	     */
	    @Deprecated
	    public void getAdmin() {
	        var user = getCurrentUser();
	        user.setRole(Role.ROLE_ADMIN);
	        save(user);
	    }
}
