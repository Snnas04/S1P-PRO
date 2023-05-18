# INTERFICIES VS CLASSES ABSTRACTES

## Diferencies entre els dos metodes

### Interfície
#### Aventatges
**Flexibilitat en la herència:** Una classe pot implementar múltiples interfícies, cosa que permet la implementació de múltiples comportaments i la reutilització de codi en diversos contextos. En canvi, les classes abstractes permeten només una única herència, ja que Java no suporta l'herència múltiple de classes.

**Baix acoblament:** L'ús d'interfícies redueix l'acoblament entre components del sistema. Les classes que implementen una interfície no necessiten saber els detalls interns de les altres classes. Això permet canviar les implementacions de les classes sense afectar la resta del sistema.

#### Desventatges
**Limitacions en la implementació:** Les interfícies no poden contenir implementacions de mètodes. Això significa que totes les classes que les implementen han de proporcionar una implementació completa per a tots els mètodes de la interfície, fins i tot si alguns mètodes no són rellevants per a aquesta classe en particular.

**Canvis en la interfície:** Si es fa un canvi en una interfície existent, totes les classes que la implementen han d'ajustar-se i proporcionar una nova implementació per als mètodes modificats.

### Classe Abstracte
#### Aventatges
**Reutilització de codi:** Les classes abstractes permeten proporcionar una implementació base comuna per a les classes derivades, evitant la duplicació de codi. Útil quan hi ha funcionalitats compartides entre diferents classes.

**Comportament predeterminat:** Les classes abstractes poden contenir mètodes amb implementacions concretes, cosa que permet definir comportaments predeterminats que les classes derivades heretaran. Així les classes que heredin d'una classe abstracte no hauran de proporcionar una implementació per aquests mètodes si no en necessiten que sigui diferent.

**Jerarquia més específica:** Amb les classes abstractes es pot establir una jerarquia més específica i definir comportaments compartits entre un grup de classes relacionades. Això proporciona una estructura més rígida i controlada en comparació amb les interfícies, que són més adequades per a comportaments més genèrics.

#### Desventatges
**Limitació en l'herència:** Una classe només pot heretar d'una única classe abstracta. Això restringeix la flexibilitat en comparació amb les interfícies. Si una classe ja hereta d'una classe abstracta, no pot heretar de cap altra classe,

**Acoblament:** En utilitzar una classe abstracta com a base, les classes derivades estan acoblades a la implementació de la classe abstracta.Qualsevol canvi en la classe abstracta pot tenir efectes en totes les classes derivades. Ja que Java no admet l'herència múltiple de classes.

## Elecció entre Interfície o Classe Abstracta
Jo preferesc una **Classe Abstracta** per les següents raons:
- Proporcionar una implementació base comuna per a les classes derivades permetent la reutilització de codi i evita la duplicació innecessària.
- Definir comportaments predeterminats per a uns certs mètodes que poden ser heretats per les classes derivades.
- Forma una estructura més solida i flexible davant futurs canvis.
- Es poden deixar alguns mètodes sence implementar.
- Agrupar classes relacionades sota una classe abstracta comuna i definir comportaments i característiques compartits en aquesta classe abstracta.