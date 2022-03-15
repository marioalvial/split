down:
	@docker-compose down --v

run:
	@$(MAKE) down
	docker compose up -d --build
