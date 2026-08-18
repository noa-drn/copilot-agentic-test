# copilot-agentic-test

A small Kotlin project used to test an agentic dev workflow (coder, PR author, reviewer)
on a realistic student setup. The task is one bounded piece of business logic with
provided acceptance tests, so success is checkable.

## The task

Implement `TodoService.upcomingTodos(todos, now)` in
`src/main/kotlin/com/noaduron/todo/TodoService.kt`.

A todo is **upcoming** when all of the following hold:

- its status is not `ARCHIVED`;
- it has a due date (not null);
- its due date is on or after `now` (a todo due exactly on `now` is included).

The result is sorted by due date ascending (earliest first). Everything else is excluded.

The full acceptance tests live in
`src/test/kotlin/com/noaduron/todo/TodoServiceTest.kt`. The implementation must pass them.

## Build and test

```
./gradlew test
```

CI runs the same tests on every push and pull request (`.github/workflows/ci.yml`).

## Delivery standards (this is what we judge)

Success is not the exact code, it is whether the delivery follows these standards.
The point of the exercise is to steer the agents, through your prompts, so that what
they produce respects them.

### Code style

- Kotlin official style, 4-space indentation.
- No unused imports, no dead code, no commented-out code.
- Public functions keep a KDoc comment.

### Commit messages

- One logical change per commit.
- Subject in the imperative, max 50 characters, capitalized, no trailing period.
  Example: `Implement upcomingTodos filtering and sorting`
- Optional body after a blank line, explaining the why, wrapped at ~72 characters.
- No AI attribution or co-author trailers.

### Pull request

The PR description must contain these sections, in this order:

- **Context** — why this change exists.
- **What changed** — the concrete changes.
- **Why** — the reasoning behind the approach.
- **Potential bugs** — risks or edge cases to watch.
- **Future improvements** — what could come next.
