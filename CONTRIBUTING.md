# Contributing to Store App

Thank you for your interest in contributing to **Store App**! 

To keep the codebase clean, robust, and easy to maintain, please follow these guidelines when submitting contributions.

---

## 1. Getting Started & Git Workflow

### Step 1: Sync with `main` and create a feature branch
Always start from the latest `main` branch:
```bash
git checkout main
git pull origin main
git checkout -b feat/your-feature-name
```
> Use descriptive branch names like `feat/product-price-range`, `fix/order-delete-response`, or `test/category-service`.

### Step 2: Make your changes
- Follow the existing architecture and patterns:
  - **Controller**: REST endpoints, request validation (`@Valid`, `@Positive`).
  - **Service**: Business logic, caching annotations (`@Cacheable`, `@CacheEvict`).
  - **Repository**: Spring Data JPA query methods.
  - **Mapper**: MapStruct mappings between Entity and DTO.

### Step 3: Database Migrations Rule (Crucial ⚠️)
- **NEVER edit or delete existing migration files** in `src/main/resources/db/migration/`. Flyway will fail on checksum mismatches.
- If your change requires schema changes, **always add a new migration file** with the next version number (e.g., `V7__your_migration_description.sql`).

---

## 2. Before Opening a Pull Request

Always run the following commands locally to ensure your changes comply with formatting and pass all tests:

### 1. Code Formatting
Auto-format your code and verify there are no style violations:
```bash
# Auto-format all files
./mvnw formatter:format

# Validate formatting (same check run by CI)
./mvnw formatter:validate
```

### 2. Build & Test
Run the full verification lifecycle (compilation, all tests, and packaging):
```bash
./mvnw clean verify
```
> Ensure your local MySQL and Redis containers are running (`docker compose up -d`) before running tests.

---

## 3. Commit Message Conventions

We follow **Conventional Commits**. Please format your commit messages clearly:

```text
<type>(<scope>): <short description>
```

### Common Types:
- `feat`: A new feature (e.g., `feat(product): add price range filter endpoint`)
- `fix`: A bug fix (e.g., `fix(order): return no content on successful delete`)
- `style`: Formatting changes (e.g., `style: format codebase with formatter-maven-plugin`)
- `test`: Adding or improving tests (e.g., `test(category): add unit tests for CategoryService`)
- `docs`: Documentation updates (e.g., `docs: update README with getting started guide`)
- `refactor`: Code change that neither fixes a bug nor adds a feature

---

## 4. Submitting Your Pull Request

### Keep your branch updated
Before pushing, fetch the latest changes from `main` and rebase your branch:
```bash
git fetch origin
git rebase origin/main
```
If there are any merge conflicts, resolve them, run `./mvnw clean verify`, and continue the rebase:
```bash
git add <resolved-files>
git rebase --continue
```

### Push and open a PR
Push your branch to GitHub:
```bash
git push -u origin feat/your-feature-name
```
Then open a Pull Request against the `main` branch.

### Verify CI
Once your PR is created, GitHub Actions will automatically run the CI pipeline:
1. **Formatting**: Checks code style compliance.
2. **Build**: Verifies compilation of main and test sources.
3. **Test & Verify**: Runs the complete test suite.
4. **Run (Smoke Test)**: Verifies the application boots and responds to health checks.

> All 4 CI checks must pass before a PR can be merged.

### If CI Fails
- Click **Details** on the failed job in your PR to inspect the build logs.
- Identify the root cause (e.g., formatting violation, failing test, or compilation error).
- Fix the issue locally, verify with `./mvnw clean verify`, and push your fix. **Do not wait for a maintainer to notify you—proactively investigate and resolve any CI failure on your PR.**
