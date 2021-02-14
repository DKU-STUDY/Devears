import i18next from 'i18next';
import { initReactI18next } from 'react-i18next';
import { ko } from './locales';

const KO = 'ko';

const ns = [ 'common', 'user', 'study' ];

i18next
  .use(initReactI18next)
  // https://www.i18next.com/overview/configuration-options
  .init({
    whitelist: [ KO ],
    fallbackLng: KO ,
    load: 'languageOnly',
    resources: { ko },
    ns,
    defaultNS: 'common',
    react: {
      wait: true,
      bindI18n: 'languageChanged loaded',
      useSuspense: false,
      nsMode: "default",
      transSupportBasicHtmlNodes: true,
      transKeepBasicHtmlNodesFor: ['br', 'strong', 'i']
    }
  });

export default i18next;
