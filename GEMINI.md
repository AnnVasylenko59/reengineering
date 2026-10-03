# Lab 3 Java project rules
## Technical rules
- Java 21.
- Maven project.
- Production code is in src/main/java.
- Tests are in src/test/java.
- FunList objects must remain immutable.
- Do not change public API unless the prompt explicitly allows it.
- Do not remove, disable or weaken a failing test just to make the build green.
- Do not replace Empty Singleton with null.
- After code changes, run mvn test.
- After Javadoc changes, run mvn javadoc:javadoc.
## Working style
- Before editing files, briefly explain the plan.
- Make small, reviewable changes.
- Explain why each change is needed.
- If requirements are ambiguous, ask rather than inventing behavior.
- Never expose secrets, API keys, passwords or personal data.
## Safety and verification
- Never modify files outside the current project.
- Never access .env, API keys, passwords or private files.
- Human approval is required before production-code edits.
- If a command fails, report the failure instead of hiding it.