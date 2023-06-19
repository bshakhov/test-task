import {Provider, Type} from '@angular/core';
import Spy = jasmine.Spy;

export type Mock<T> = T & { [P in keyof T]?: Spy | any };

export class MockingUtil {
  static createMock = ((obj: Type<any>): Mock<any> => {
    return jasmine.createSpyObj(obj.name, Object.getOwnPropertyNames(obj.prototype).filter((propertyName) => {
      const descriptor = Object.getOwnPropertyDescriptor(obj.prototype, propertyName);

      // @ts-ignore
      return (descriptor.value instanceof Function) && !descriptor.get && !descriptor.set;
    }));
  });

  static createMockProvider = ((service: Type<any>): Provider => {
    return {provide: service, useValue: MockingUtil.createMock(service)};
  });
}
