# Contributing Guide

> **First-Time Contributors Welcome!**  
> This is a personal learning project, but it is open for anyone who wants to practice and simulate real-world open-source contributions (branching, pull requests, commit squashing, conventional commits, and CI pipelines). If you are looking to practice and make your first contribution, you are warmly welcomed!  
> ⭐ Don't forget to **star the repo** and share it with friends who want to learn and practice too!

Please follow this simple workflow to ensure quick and smooth reviews.

---

## 1. Branch & Develop

1. **Sync with latest `main`**:
   ```bash
   git checkout main && git pull origin main
   git checkout -b feat/your-feature-name
   ```
2. **Follow existing patterns**: Keep controllers, services, repositories, and MapStruct mappers aligned with the current structure.
3. **Database Migrations Rule (Crucial)**:
   - **Never edit or delete existing migration files** in `src/main/resources/db/migration/`.
   - If schema changes are needed, **add a new migration file** with the next version (e.g. `V7__description.sql`).

---

## 2. Format & Verify Locally

Before committing, ensure your code complies with formatting and passes all tests:

```bash
# 1. Format code
./mvnw formatter:format

# 2. Check formatting (same check as CI)
./mvnw formatter:validate

# 3. Compile, run tests, and package (requires docker compose up -d)
./mvnw clean verify
```

---

## 3. Commit Conventions

We follow **Conventional Commits**:
```text
<type>(<scope>): <short description>
```
* `feat`: New feature (e.g., `feat(product): add price range filter`)
* `fix`: Bug fix (e.g., `fix(order): return 204 on successful deletion`)
* `style`: Code style / formatting (e.g., `style: format codebase`)
* `test`: Adding or updating tests (e.g., `test(category): add unit tests`)
* `docs`: Documentation changes (e.g., `docs: update README`)

---

## 4. Rebase, Squash & Submit PR

1. **Rebase on `main`**:
   ```bash
   git fetch origin
   git rebase origin/main
   ```
2. **Squash commits to 1 (Keep history linear)**:
   Every PR should have **only 1 semantic commit**. If you made multiple commits, squash them:
   ```bash
   git rebase -i origin/main
   ```
   *(Keep the first commit as `pick`, change others to `squash` or `s`, and save).*
3. **Push and open a PR**:
   ```bash
   git push -u origin feat/your-feature-name
   ```
4. **Inspect CI**:
   All 4 GitHub Actions jobs (`formatting`, `build`, `test`, `run`) must pass. If any job fails, click **Details**, inspect the error log, fix it locally, and push. *Do not wait for a maintainer to point out CI failures.*
