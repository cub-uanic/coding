const defaultSettings = {
  env: { es2021: true, node: true },
  parser: 'babel-eslint',
  parserOptions: {
    ecmaVersion: 2020,
    sourceType: 'module',
  },
}

const jsSettings = {
  ...defaultSettings,
  files: ['src/main/**/*.js', 'src/main/**/*.jsx'],
  parserOptions: {
    ...defaultSettings.parserOptions,
    ecmaFeatures: { jsx: true },
  },
  plugins: ['node', 'mocha', 'security'],
  extends: [
    'airbnb-base',
    'plugin:node/recommended',
    'plugin:mocha/recommended',
    'plugin:security/recommended',
    'prettier',
  ],
  rules: {
    'no-unused-vars': [
      'error',
      {
        args: 'none',
        ignoreRestSiblings: true,
        vars: 'all',
        varsIgnorePattern: '^_+$',
      },
    ],
    'no-control-regex': 0,
    'no-use-before-define': [
      'error',
      {
        functions: false,
        classes: true,
        variables: true,
      },
    ],
    'no-underscore-dangle': ['off'],
    'import/no-default-export': ['warn'],
    'no-console': ['off'],
  },
}

const jsonSettings = {
  ...defaultSettings,
  files: ['*.json', 'src/**/*.json'],
  plugins: ['json'],
  extends: ['plugin:json/recommended-with-comments', 'prettier'],
}

const tsSettings = {
  files: ['src/main/**/*.ts', 'src/main/**/*.tsx'],
  parser: '@typescript-eslint/parser',
  parserOptions: {
    ...jsSettings.parserOptions,
    project: './tsconfig.json',
    warnOnUnsupportedTypeScriptVersion: false,
  },
  plugins: ['tsc', '@typescript-eslint'],
  extends: [
    'airbnb-typescript/base',

    // 'plugin:@typescript-eslint/recommended',
    'plugin:@typescript-eslint/recommended-requiring-type-checking',
    'prettier/@typescript-eslint',
    'plugin:prettier/recommended',

    // 'plugin:@typescript-eslint/recommended',
    // 'plugin:@typescript-eslint/recommended-requiring-type-checking',
    // 'prettier',
    // 'prettier/@typescript-eslint',
  ],
  rules: {
    ...jsSettings.rules,
    'tsc/config': ['error', { configFile: 'tsconfig.json' }],
    '@typescript-eslint/member-delimiter-style': [
      'error',
      {
        multiline: { delimiter: 'semi', requireLast: true },
        singleline: { delimiter: 'semi', requireLast: false },
      },
    ],
    '@typescript-eslint/no-unused-vars': 'error',
  },
}

const jsTestSettings = {
  ...jsSettings,
  files: ['tests/**/*.js', 'tests/**/*.jsx'],
  env: { ...jsSettings.env, jest: true },
  plugins: [...jsSettings.plugins, 'jest'],
  extends: [...jsSettings.extends, 'plugin:jest/recommended'],
  rules: {
    ...jsSettings.rules,
    // '@typescript-eslint/ban-ts-ignore': 'off',
    // '@typescript-eslint/no-empty-function': 'off',
    // '@typescript-eslint/no-explicit-any': 'off',
    // 'import/first': 'off',
  },
}

const tsTestSettings = {
  ...tsSettings,
  files: ['tests/**/*.ts', 'tests/**/*.tsx'],
  env: { ...tsSettings.env, jest: true },
  plugins: [...tsSettings.plugins, 'jest'],
  extends: [...tsSettings.extends, 'plugin:jest/recommended'],
  rules: {
    ...tsSettings.rules,
    // '@typescript-eslint/ban-ts-ignore': 'off',
    // '@typescript-eslint/no-empty-function': 'off',
    // '@typescript-eslint/no-explicit-any': 'off',
    // 'import/first': 'off',
  },
}

module.exports = {
  ...defaultSettings,
  overrides: [
    jsSettings,
    jsonSettings,
    tsSettings,
    jsTestSettings,
    tsTestSettings,
  ],
}
