/**
 * 📌 Phase: Essentials
 * 📌 Concept: Props
 * 📌 Status: ❌ Not Done
 * 📌 Priority: ⭐ High
 */

import React from "react";

const Child = ({ name }) => {
  return <h2>Hello, {name}</h2>;
};

const Props = () => {
  return <Child name="React Learner" />;
};

export default Props;

/* 

What is it?

Props (short for properties) are read-only inputs passed from parent to child components.

Why is it used?

Enables component reusability

Helps pass dynamic data

Where is it used?

Passing user data

Reusable UI components (cards, buttons)

How is it used?

Passed as attributes

Accessed via function parameters

When should it be used?

When data needs to flow parent → child

🎯 Interview Insight

👉 Props are immutable
👉 Helps maintain unidirectional data flow

⚠️ Common Mistakes

Trying to modify props ❌

🚀 Real-World Example

"In a dashboard, props were used to pass API data to multiple card components, avoiding duplication."

*/